var exec = require('cordova/exec');

exports.showToast = function (arg0, success, error) {
    exec(success, error, 'showToast', 'showToast', [arg0]);
};
exports.init = function (arg0, success, error) {
    exec(success, error, 'init', 'init', [arg0]);
};

