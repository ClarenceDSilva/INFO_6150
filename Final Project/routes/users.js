var express = require('express');
var router = express.Router();
var mongo = require('mongoose');
var assert = require('assert');
var csrf = require('csurf');
var passport = require('passport');

var csrfProtection = csrf();
router.use(csrfProtection);
mongo.connect("mongodb://127.0.0.1:27017/test")

/* GET profileSetup page. */
router.get('/profileSetup',isLoggedIn, function(req, res, next) {
    res.render('profileSetup', { title: 'NU-Careers: profile setup' });
});

router.get('/viewAndApplyJobs',isLoggedIn, function(req, res, next) {
    res.render('viewAndApplyJobs', { title: 'NU-Careers: view and apply jobs' });
});

router.get('/viewMyApplications',isLoggedIn, function(req, res, next) {
    res.render('viewMyApplications', { title: 'NU-Careers: view my applications' });
});

router.get('/logout', isLoggedIn, function (req,res,next) {
    req.logout();
    res.redirect('/index');

});

/*
router.use('/', notLoggedIn, function (req, res,next) {
   next();
});
*/

/* GET users listing. */
router.get('/', function(req, res, next) {
    res.send('respond with a resource');
});


/* GET login page. */
router.get('/login', function(req, res, next) {
    var messages = req.flash('error');
    res.render('login', {csrfToken: req.csrfToken(), messages: messages, hasErrors: messages.length > 0});
});

router.post('/login', passport.authenticate('local.signin', {
    successRedirect: 'profileSetup',
    failureRedirect: 'login',
    failureFlash: true
}));


/* GET signin page. */
router.get('/signin', function(req, res, next){
    var messages = req.flash('error');
    res.render('signin', {csrfToken: req.csrfToken(), messages: messages, hasErrors: messages.length > 0});
});

router.post('/signin', passport.authenticate('local.signup', {
    successRedirect: 'login',
    failureRedirect: 'signin',
    failureFlash: true
}));



module.exports = router;

function isLoggedIn(req, res, next){
    if(req.isAuthenticated())
    {
        return next();
    }
    res.redirect('/index');
}

function notLoggedIn(req, res, next){
    if(!req.isAuthenticated())
    {
        return next();
    }
    res.redirect('/index');
}

