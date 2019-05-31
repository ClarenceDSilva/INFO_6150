var mongoose = require('mongoose');
var passport = require('passport');
var User = require('../models/user');
var Employeer = require('../models/employeer');
var LocalStrategy = require('passport-local').Strategy;
/*var userSchema = require('../models/user');
var User = mongoose.model('userSchema',userSchema);*/



passport.serializeUser(function (user, done) {
    done(null, user.id);
});


passport.deserializeUser(function (id, done) {

    User.findById(id, function (err, user) {
        done(err, user);
    });
});

passport.use('local.signup', new LocalStrategy({
    usernameField: 'username',
    /*emailField: 'email',*/
    passwordField: 'password',
    passReqToCallback: true
}, function (req, username, password, done) {

    console.log("In local.signup funtion");
    req.checkBody('username', 'Invalid username').notEmpty();
    req.checkBody('password', 'Invalid password').notEmpty().isLength({min: 8});
    var errors = req.validationErrors();

    if(errors){
        var messages = [];
        errors.forEach(function(error){
            messages.push(error.msg);
        });
        return done(null, false, req.flash('error', messages));
    }
    User.findOne({'username': username}, function (err, user) {

        //console.log("In User.findone ");
        if(err){
            return done(err);
        }
        if(user){
            return done(null, false,{message: "Username already exists."});
        }

        var newUser = new User();
        newUser.username = username;
        /*newUser.email = email;*/
        newUser.password = newUser.encryptPassword(password);
        newUser.save(function (err, result) {
            //console.log
            if(err){
                console.log("ERROR SAVE");
                return done(err);

            }
            //console.log("ERROR SUCCESS");
            return done(null, newUser);
        });

        /*if(email){
            return done(null, false, {message: 'Email already exists'});
        }*/

    });
}));

passport.use('local.signin', new LocalStrategy({
    usernameField: 'username',
    /*emailField: 'email',*/
    passwordField: 'password',
    passReqToCallback: true
}, function (req, username, password, done) {
    req.checkBody('username', 'Invalid username').notEmpty();
    req.checkBody('password', 'Invalid password').notEmpty();
    var errors = req.validationErrors();

    if(errors){
        var messages = [];
        errors.forEach(function(error){
            messages.push(error.msg);
        });
        return done(null, false, req.flash('error', messages));
    }

    User.findOne({'username': username}, function (err, user) {

        console.log("In User.findone ");
        if(err){
            return done(err);
        }
        if(!user){
            return done(null, false,{message: "No user found."});
        }
        if(!user.validPassword(password)){
            return done(null, false,{message: "Wrong password."});
        }

        return done(null, user);
        /*if(email){
            return done(null, false, {message: 'Email already exists'});
        }*/

    });
}));

/*---------------------------------For Employeers------------------------------------------------*/


passport.serializeUser(function (employeer, done) {
    done(null, employeer.id);
});


passport.deserializeUser(function (id, done) {

    Employeer.findById(id, function (err, employeer) {
        done(err, employeer);
    });
});


passport.use('local.empsignup', new LocalStrategy({
    usernameField: 'username',
    /*emailField: 'email',*/
    passwordField: 'password',
    passReqToCallback: true
}, function (req, username, password, done) {

    console.log("In local.signup function");
    req.checkBody('username', 'Invalid username').notEmpty();
    req.checkBody('password', 'Invalid password').notEmpty().isLength({min: 8});
    var errors = req.validationErrors();

    if(errors){
        var messages = [];
        errors.forEach(function(error){
            messages.push(error.msg);
        });
        return done(null, false, req.flash('error', messages));
    }
    Employeer.findOne({'username': username}, function (err, user) {

        console.log("In User.findone ");
        if(err){
            return done(err);
        }
              if(user){
                  return done('Username already exists', false);
              }

        var newEmp = new Employeer();
        newEmp.username = username;
        /*newUser.email = email;*/
        newEmp.password = newEmp.encryptPassword(password);
        newEmp.save(function (err, result) {
            //console.log
            if(err){
                console.log("ERROR SAVE");
                return done(err);

            }
            console.log("ERROR SUCCESS");
            return done(null, newEmp);
        });

        /*if(email){
            return done(null, false, {message: 'Email already exists'});
        }*/

    });
}));

passport.use('local.empsignin', new LocalStrategy({
    usernameField: 'username',
    /*emailField: 'email',*/
    passwordField: 'password',
    passReqToCallback: true
}, function (req, username, password, done) {
    req.checkBody('username', 'Invalid username').notEmpty();
    req.checkBody('password', 'Invalid password').notEmpty();
    var errors = req.validationErrors();

    if(errors){
        var messages = [];
        errors.forEach(function(error){
            messages.push(error.msg);
        });
        return done(null, false, req.flash('error', messages));
    }

    Employeer.findOne({'username': username}, function (err, user) {

        console.log("In User.findone ");
        if(err){
            return done(err);
        }
        if(!user){
            return done(null, false,{message: "No user found."});
        }
        if(!user.validPassword(password)){
            return done(null, false,{message: "Wrong password."});
        }

        return done(null, user);
        /*if(email){
            return done(null, false, {message: 'Email already exists'});
        }*/

    });
}));
