var express = require('express');
var router = express.Router();
var mongo = require('mongoose');
var assert = require('assert');
/*var csrf = require('csurf');*/
/*var passport = require('passport');*/

/*
var csrfProtection = csrf();
router.use(csrfProtection);
*/

var url = 'mongodb://127.0.0.1:27017/test';


/*mongo.connect("mongodb://127.0.0.1:27017/test")*/
/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index');
});

router.get('/index', function(req, res, next) {
    res.render('index');
});

router.get('/faq', function(req, res, next) {
    res.render('faq');
});

router.get('/aboutUs', function(req, res, next) {
    res.render('aboutUs');
});


/*/!* GET login page. *!/
router.get('/login', function(req, res, next) {
    var messages = req.flash('error');
    res.render('login', {csrfToken: req.csrfToken(), messages: messages, hasErrors: messages.length > 0});
});

router.post('/login', passport.authenticate('local.signin', {
    successRedirect: '/profileSetup',
    failureRedirect: '/login',
    failureFlash: true
}));

/!* GET postJob page. *!/
router.get('/postJob', function(req, res, next) {
    res.render('postJob', { title: 'NU-Careers: post a job' });
});

/!* GET profileSetup page. *!/
router.get('/profileSetup', function(req, res, next) {
    res.render('profileSetup', { title: 'NU-Careers: profile setup' });
});

/!* GET signin page. *!/
router.get('/signin', function(req, res, next){
    var messages = req.flash('error');
    res.render('signin', {csrfToken: req.csrfToken(), messages: messages, hasErrors: messages.length > 0});
});

router.post('/signin', passport.authenticate('local.signup', {
    successRedirect: '/login',
    failureRedirect: '/signin',
    failureFlash: true
}));*/


router.get('./get-data', function (req, res, next) {
    var resultArray = [];
    mongo.connect(url, function(err, db){
        assert.equal(null,err);
        var cursor = db.collection('jobdata').find();
        cursor.forEach(function(doc,err) {
            assert.equal(null, err);
            resultArray.push(doc);
        }, function () {
            db.close();
            res.render('index', {items: resultArray});
        });
    });
});

router.post('./insert', function (req, res, next) {
    var job = {
        title: req.body.title,
        phone: req.body.phone,
        address: req.body.address,
        city: req.body.city,
        state: req.body.state,
        website: req.body.website,
        comment: req.body.comment

    };
    mongo.connect(url, function (err, db) {
        assert.equal(null,err);
        db.collection('jobdata').insertOne(item, function(err, result){
            assert.equal(null,err);
            console.log('Job added');
            db.close();
        });
    });
    res.redirect('/postAJob');
});

router.post('./update', function (req, res, next) {

});

router.post('./delete', function (req, res, next) {

});

router.get('/abc', function(req, res, next) {
  res.render('abc', { title: 'abc' });
});

module.exports = router;
