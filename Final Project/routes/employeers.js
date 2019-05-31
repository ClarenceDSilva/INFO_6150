var express = require('express');
var router = express.Router();
var mongo = require('mongoose');
var assert = require('assert');
var csrf = require('csurf');
var passport = require('passport');

var csrfProtection = csrf();
router.use(csrfProtection);
mongo.connect("mongodb://127.0.0.1:27017/test")


/* GET postJob page. */
router.get('/postJob', function(req, res, next) {
    res.render('postJob', { title: 'NU-Careers: post a job' });
});

router.get('/viewCandidates',  function(req, res, next) {
    res.render('viewCandidates', { title: 'NU-Careers: view candidates' });
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
router.get('/empLogin', function(req, res, next) {
    var messages = req.flash('error');
    res.render('empLogin', {csrfToken: req.csrfToken(), messages: messages, hasErrors: messages.length > 0});
});

router.post('/empLogin', passport.authenticate('local.empsignin', {
    successRedirect: 'postJob',
    failureRedirect: 'empLogin',
    failureFlash: true
}));


/* GET signin page. */
router.get('/empSignin', function(req, res, next){
    var messages = req.flash('error');
    res.render('empSignin', {csrfToken: req.csrfToken(), messages: messages, hasErrors: messages.length > 0});
});

router.post('/empSignin', passport.authenticate('local.empsignup', {
    successRedirect: 'empLogin',
    failureRedirect: 'empSignin',
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

