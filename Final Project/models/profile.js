var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var schema = new Schema({
    firstName: {type: String, required: true},
    lastName: {type: String, required: true},
    email: {type: String, required: true},
    add1 : {type: String, required: true},
    add2: {type: String, required: false},
    majorCat: {type: String, required: true},
    major: {type: String, required: true},
    jobRole: {type: String, required: true},
    resume: {type: BSON, required: false}

});

module.exports = mongoose.model('Profile', schema);