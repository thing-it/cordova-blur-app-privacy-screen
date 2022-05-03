/*global cordova, module*/

module.exports = {
    updateSecureFlag: function (isEnableFlag, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "BlurAppPrivacyScreen", "updateSecureFlag", [isEnableFlag]);
    }
};
