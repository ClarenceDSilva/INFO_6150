var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var bcrypt = require('bcrypt-nodejs');

var employeerSchema = new Schema({
    username: {type: String, required: true},
    /*email: {type: String, required: true},*/
    password: {type: String, required: true}
});

employeerSchema.methods.encryptPassword = function (password) {
    return bcrypt.hashSync(password, bcrypt.genSaltSync(5), null);
};

employeerSchema.methods.validPassword = function (password) {
    return bcrypt.compareSync(password, this.password);
};

module.exports = mongoose.model('Employeer', employeerSchema);

