/**
 * FindThief.js - Coding Challenge
 * @author Thomas Yamakaitis
 * @version 1.0
 * @description Assume there is a thief hiding in a line of caves. Every day the thief will move either left or right one and only one cave. You are allowed to check any cave, once a day. Given that there is k caves and m days to find the thief, find a solution that will work for any k and m.
 *
 * This is a bit tricky so I offer an alternative question: Given an infinite amount of days, could you come up with a way to find the thief given there are 5 caves.
 * Here is an example start of this scenerio: [0, 0, 1, 0, 0] given 1 = the thief.
 *
 * I encourage you to try and solve for 5 caves and look for a pattern in your algorithm that can be applied to the rest of the situations. Then, try and find the lower and upper bounds for the days you need in relation to k caves. If you are interested in the answer or need help, feel free to dm me on slack.
 * To clarify: Your algorithm for finding the thief for 5 caves and infinite days must work no matter the path the thief takes. This was an interview question received from one of the top 5 companies in tech so really try and think this one out.
 */

var caves = new Array();
var foundThief = false;
var length = prompt("How many caves?", 6);

for (var i = 0; i < length; i++) {
	caves[i] = 0;
}

var thief = Math.floor(Math.random() * length);
caves[thief] = 1;

var start = 1;

if(length == 1) {
	start = 0;
}
var count = 0;
var direction = 0; // -1 = left; 0 = wait; 1 = right;

while(!foundThief) {
	count++;
  caves[start] += 2;
  // window.alert(caves); // Uncomment this line to visualize thief and yourself moving...
  if(caves[start] == 3) {
  	foundThief = true;
    window.alert("[" + caves + "]\nTries: " + count + "\n" + "YOU FOUND THE THIEF!");
    console.log("# of Caves: " + length + "\nSetup: [" + caves + "]\nTries: " + count);
  } else {
  	caves[start] -= 2;

    switch(direction) {
    	case -1:
      	start--;
        if(start == 1) {
        	direction++;
        }
        break;
  		case 0:
      	switch(start) {
        	case 1:
          	direction++;
            break;
          case (length - 2):
          	direction--;
            break;
        }
        break;
      case 1:
      	start++;
        if(start == length -2) {
        	direction--
        }
        break;
    }


    thief = moveThief(thief);

    if(count > 10000) {
    	foundThief = true;
      window.alert("This took 100+ tries; try something else.");
    }
  }
}

function moveThief(thief) {
	caves[thief]--;
	var leftRight = Math.floor(Math.random() * 2);

  if(thief == 0) {
  	thief++;
  } else if(thief == (length - 1)) {
  	thief--;
  } else {
  	if(leftRight == 1) {
  		thief++;
    } else {
      thief--;
    }
  }

  caves[thief]++;
  return thief;
}
