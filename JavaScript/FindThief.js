// Find the Thief - Coding Challenge
// Author: Thomas Yamakaitis
// Assume there is a thief hiding in a line of caves. Every day the thief will move either left or right one and only one cave. You are allowed to check any cave, once a day. Given that there is k caves and m days to find the thief, find a solution that will work for any k and m.
//
// This is a bit tricky so I offer an alternative question: Given an infinite amount of days, could you come up with a way to find the thief given there are 5 caves.
// Here is an example start of this scenerio: [0, 0, 1, 0, 0] given 1 = the thief.
//
// I encourage you to try and solve for 5 caves and look for a pattern in your algorithm that can be applied to the rest of the situations. Then, try and find the lower and upper bounds for the days you need in relation to k caves. If you are interested in the answer or need help, feel free to dm me on slack.
//
// To clarify: Your algorithm for finding the thief for 5 caves and infinite days must work no matter the path the thief takes. This was an interview question received from one of the top 5 companies in tech so really try and think this one out.

var caves = new Array();
var foundThief = false;
var length = prompt("How many caves?", 5);

for (var i = 0; i < length; i++) {
	caves[i] = 0;
}

var thief = parseInt(Math.random() * length, 10);
caves[thief] = 1;

var start = length - 1;

var count = 0;
var direction = true; // false = left

while(!foundThief) {
	count++;
  caves[start] += 2;
  console.log(caves);
  if(caves[start] == 3) {
  	foundThief = true;
    window.alert(caves + "\n" + count + "\n" + "YOU FOUND THE THIEF!");
  } else {
  	caves[start] -= 2;

    if(start == 0) {
    	start += (length - 1);
    } else {
    	start = parseInt(start / 2);
    }

    thief = moveThief(thief);

    if(count > 100) {
    	foundThief = true;
      window.alert("This took 10+ tries; try something else.");
    }
  }
}

function moveThief(thief) {
	caves[thief]--;
	var leftRight = parseInt(Math.random() * 2, 10);

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
