const mongojs = require('mongojs'); //imports 'mongojs'
const assert = require('assert'); //Assertion for queries

// Connection URL
const url = "mongodb://localhost:42000/Lab6"; 
//URL with database included for local mongo db

// Database Name
const collections=["Restaurants"]; //list of collections that you will be accessing. 
mongodb = mongojs(url, collections);

module.exports = {
        
    printAllInCollection : function(collectionName, callback){
        var cursor = mongodb.collection(collectionName).find({}).limit(10, function(err, docs){

            if(err || !docs) {
                console.log("Cannot print database or database is empty\n");
            }
            else {
                //console.log(collectionName, docs);

                callback(docs);
            }
        });

    },

    getCollection: function(collectionName, callback){
        var cursor = mongodb.collection(collectionName).find({}).limit(10, function(err, docs){

            if(err || !docs) {
                console.log("Cannot print database or database is empty\n");
            }
            else {
                //console.log(collectionName, docs);

                callback(docs);
            }
        });
	},

    

    createCollection: function(collectionName, callback){
    	var cursor = mongodb.createCollection(collectionName, function(err) {
			if(err)
			{
				return callback("409");
			}
			else
			{
				return callback("201");
			}
		});
    },

	
	insertToCollection : function(collectionName, objectinserted, callback){
		var cursor = mongodb.collection(collectionName).insert({objectinserted});
		callback(objectinserted);
	}
}

