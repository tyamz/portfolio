/**
 * URLify - JavaScript Version
 * @author Thomas Yamakaitis
 * @version 2.0
 * @copyright 2016 - Thomas Yamakaitis
 */

var url = requestUrl();

window.alert(url);

function requestUrl() {
  if(confirm("Use the current URL?")) {
    return window.location.href;
  } else {
    return prompt("Enter a URL...");
  }
}
