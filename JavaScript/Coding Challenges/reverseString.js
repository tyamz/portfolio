/**
 * reverseString - JavaScript Version
 * @author Thomas Yamakaitis
 * @version 1.0
 * @copyright 2016 - Thomas Yamakaitis
 */

function reverseString(str) {
  if(str.length == 1) {
    return str;
  }
  var string = [];
  var x = str.length - 1;
  for(var i = 0; i < str.length; i++) {
    if(i == x) {
      string.splice(i,0,str.charAt(i));
    } else {
      string.splice(i,0,str.charAt(x),str.charAt(i));
    }
    window.alert(string + "\nx: " + x + "\ni: " + i);
    if(i == x || i == (x - 1)) {
      break;
    }
    x--;
  }
  return string.join("");
}

reverseString("hello");
