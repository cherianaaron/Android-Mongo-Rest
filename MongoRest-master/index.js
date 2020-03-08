var express = require('express')
var mongojs = require('mongojs')
var app = express()
var db = require('./myDB.js')

app.use(express.json())
app.get('/', (req, res) => {console.log("HELLO");})

app.get('/getAll', (req, res) => {
  db.printAllInCollection('Restaurants', function(docs){
    console.log("Cities: ", docs);
    res.send(docs)
  });
});


app.listen(42000, ()=>console.log("listening"));

app.post('/getCollection', (req, res) => {
    //res.send(req.body.name)
    db.printAllInCollection('Restaurants', function(docs){
    console.log("Cities: ", docs);
    res.send(docs)
  });
});

app.post('/createCollection', (req, res) => {
	//stub
	db.createCollection("TestCollection", function(valid){
	res.json({"status": "success"});
	});
});

app.post('/insertToCollection', (req, res) => {
	//stub
	//req.body.other
	db.insertToCollection('TestCollection', {
            "name" : "test",
            "hash" : "b73d24921dea5462a00357f25e9f92c2",
            "other": {
                "id1": "junk",
                "id2": "junk"
            }

        }, function(values) {
	res.send(values);
	});
})


