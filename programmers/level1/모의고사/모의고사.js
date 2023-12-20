function solution(answers) {
  var answer = [];
  let oneSupoza = [1, 2, 3, 4, 5];
  let twoSupoza = [2, 1, 2, 3, 2, 4, 2, 5];
  let threeSupoza = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
  let score = [0, 0, 0];
  let oneIndex = 0;
  let twoIndex = 0;
  let threeIndex = 0;
  answers.map((e, index) => {
    oneSupoza[oneIndex] == e ? score[0]++ : null;
    twoSupoza[twoIndex] == e ? score[1]++ : null;
    threeSupoza[threeIndex] == e ? score[2]++ : null;
    oneIndex == oneSupoza.length - 1 ? (oneIndex = 0) : oneIndex++;
    twoIndex == twoSupoza.length - 1 ? (twoIndex = 0) : twoIndex++;
    threeIndex == threeSupoza.length - 1 ? (threeIndex = 0) : threeIndex++;
  });
  let max = Math.max(score[0], score[1], score[2]);
  score.map((e, index) => {
    max == e ? answer.push(index + 1) : null;
  });
  return answer;
}
