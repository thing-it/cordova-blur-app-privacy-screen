/*global cordova, module*/

var BlurAppPrivacyScreen = {
    updateSecureFlag: function (isEnableFlag, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "PrivacyScreenBlur", "updateSecureFlag", [isEnableFlag]);
    }
}

if (!cordova.plugins) {
    cordova.plugins = {};
}

if (!cordova.plugins.BlurAppPrivacyScreen) {
    cordova.plugins.BlurAppPrivacyScreen = BlurAppPrivacyScreen;
}

if (typeof module !== 'undefined' && module.exports) {
    module.exports = BlurAppPrivacyScreen;
}

