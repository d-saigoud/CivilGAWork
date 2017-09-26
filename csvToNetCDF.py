from netCDF4 import Dataset
import numpy as np
import pandas as pd
import numpy as np
from datetime import date

rawDump = np.array(pd.read_csv("D:/Masters/Civil_GA_Work/Wendy/FinalOutWendy_9_12_2017.csv", header=None))

data = rawDump[:, :]

lon_Values = np.unique(data[1:, 0].astype("float32"))
lat_Values = np.unique(data[1:, 1].astype("float32"))
date_Values = data[1:, 2]
precipitation_Values = data[1:, 3].astype("float32")
uniqueDates = np.unique(data[1:,2].astype(str))

lon_Values_Float32 = data[1:, 0].astype("float32")
lat_Values_Float32 = data[1:, 1].astype("float32")

root_grp = Dataset('D:/Masters/Civil_GA_Work/Wendy/menData.nc', 'w', format='NETCDF4')

root_grp.description = 'Precipitation Amt data'

root_grp.createDimension("MFCC", data.shape[0])

root_grp.createDimension("lon",len(lon_Values))
root_grp.createDimension("lat",len(lat_Values))
root_grp.createDimension("day",len(uniqueDates))

root_grp.createVariable('lon', 'float32', ('lon',))
root_grp.createVariable('lat', 'float32', ('lat',))
root_grp.createVariable('day', 'float32', ('day',))
root_grp.createVariable('precipitation_amt', 'float32', ('day', 'lat', 'lon',))

datesDict = {}
date0 = date(1900,1,1)
daysSince1900_01_01 = []

for i in range(len(uniqueDates)):
	splits = uniqueDates[i].split("/")
	date1 = date(int(splits[2]), int(splits[1]), 1)
	dateDiff = date1 - date0
	datesDict[uniqueDates[i]] = dateDiff.days
	daysSince1900_01_01.append(dateDiff.days)
	
root_grp.variables["lon"][:] = lon_Values
root_grp.variables["lat"][:] = lat_Values
root_grp.variables["day"][:] = daysSince1900_01_01
	
singleStore = {}

for i in range(len(data[1:])):
	pLon = lon_Values_Float32[i]
	pLat = lat_Values_Float32[i]
	pDate = datesDict[date_Values[i]]
	if pLon not in singleStore:
		singleStore[pLon] = {}
		
	if pLat not in singleStore[pLon]:
		singleStore[pLon][pLat] = {}
	
	singleStore[pLon][pLat][pDate] = precipitation_Values[i]
	
for i in range(len(lon_Values)):
	for j in range(len(lat_Values)):
		for k in range(len(uniqueDates)):
			if lon_Values[i] in singleStore and lat_Values[j] in singleStore[lon_Values[i]] and daysSince1900_01_01[k] in singleStore[lon_Values[i]][lat_Values[j]]:
				root_grp.variables["precipitation_amt"][k,j,i] = singleStore[lon_Values[i]][lat_Values[j]][daysSince1900_01_01[k]]
			else:
				root_grp.variables["precipitation_amt"][k,j,i] = 0
			
			print(str(i) + " : " + str(j) + " : " + str(k))

root_grp.close()