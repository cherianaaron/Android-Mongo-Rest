# Node and Mongo

## Quickstart

1. Clone the repo

2. Fill out mongod.conf and replace path with path to your directory!

   1. ```
      systemLog:
         destination: file
         path: "/PATH/mongod.log"
         logAppend: true
      storage:
         dbPath : "/PATH/mongo"
         journal:
            enabled: true
      net:
         bindIp: 0.0.0.0
         port: 12113
      setParameter:
         enableLocalhostAuthBypass: false
      
      ```

   2. ``pwd`` to find the path

   3. Replace the port with a new number

   4. Run ```mongod -f mongod.conf```

3. Using Robo3t or other mongo tool connect to your DB

   1. We will need to add some data to the collection inside our mongo server. To do this you can go to the RoboMongo database you have, create a new collection called “Restaurants” and you can add this test data into it <https://raw.githubusercontent.com/mongodb/docs-assets/primer-dataset/primer-dataset.json> add the collection name to the collection list below
   2. You only need 10 items!!! So do not worry about getting the whole data set!!!!

4. In new prompt run ```npm install``` this should install packages

   1. open myDb.js and replace out URL information of mongodb
      1. Also replace the LIST OF COLLECTIONS with the name of the collection containing the data you added in quotes
   2. open index.js and replace port numbers
   3. To start server run ```node index.js``` or ```nodejs index.js```
   
5. Now test program either on POSTMAN (GUI) or Opening it up on the android application given.



## Common Errors

### My mongodb doesn't hand and goes to a prompt

Look for the file called mongod.log. At the end of this file will be the error that is causing it not to run. 

### EADDRINUSE

This means the port number is not available. Retry with a different port number

### Node command not found

try running ```nodejs```

## Run test program

Note Included is a python test script. It will verify that your endpoints are working correctly. In order to run it make sure you have Mongo running and your Node server running as well. All you need to do to run it is execute : 

```python
python3.5 test.py -p <PORT> -n <NAME> -uid <USERNAME>
```
