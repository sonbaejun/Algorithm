const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString();
input = input.split('\n');

const inputTestCaseNum = +input[0];
const inputTestCase = [];

for (let i = 1; i <= inputTestCaseNum * 2; i++) {
    const arr = input[i].split(' ').map((item) => +item);
    if (i % 2 == 0) {
        let newArr = [];
        for (let j = 0; j < arr.length; j++) {
            newArr.push(arr[j]);
        }
        const testCase = {
            importance: newArr,
        };
        inputTestCase.push(testCase);
    } else {
        const testCase = {
            N: arr[0],
            check: arr[1],
        };
        inputTestCase.push(testCase);
    }
}

function solution(testCaseNum, inputTestCase) {
    let index = 0;
    let lootIndex = 0;
    let cnt = 0;
    let turn = 1;
    while (turn != -1) {
        cnt = 0;
        inputTestCase[lootIndex + 1].importance.forEach((data) => {
            if (inputTestCase[lootIndex + 1].importance[index] < data) {
                cnt++;
            }
        });
        if (cnt == 0) {
            if (index == inputTestCase[lootIndex].check) {
                console.log(turn);
                index = 0;
                turn = 1;
                lootIndex += 2;
                if (lootIndex == testCaseNum * 2) {
                    break;
                }
            } else if (index < inputTestCase[lootIndex].check) {
                inputTestCase[lootIndex + 1].importance.splice(index, 1);
                inputTestCase[lootIndex].check--;
                turn++;
                if (index >= inputTestCase[lootIndex + 1].importance.length) {
                    index = 0;
                }
            } else {
                inputTestCase[lootIndex + 1].importance.splice(index, 1);
                turn++;
                if (index >= inputTestCase[lootIndex + 1].importance.length) {
                    index = 0;
                }
            }
        } else {
            if(index == inputTestCase[lootIndex + 1].importance.length-1) {
                index = 0;
            } else {
                index++;
            }
        }
    }
}

solution(inputTestCaseNum, inputTestCase);