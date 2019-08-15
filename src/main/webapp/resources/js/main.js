$(document).ready(() => {
    // UnactiveButtons
    let $unactiveButton = $(".unactive-button");
    $unactiveButton.attr("disabled", "true");

    // Login popup
    let $loginPopup = $(".login-popup");
    let $loginButton = $(".header__login");
    let $loginPopupCancerButton = $(".login-popup__exit");

    $loginButton.on("click", () => {
        $loginPopup.toggleClass("login-popup-active");
    });
    $loginPopupCancerButton.on("click", () => {
        $loginPopup.removeClass("login-popup-active");
    });
});

