function solution(s, skip, index) {
  // 일단 알파벳 배열을 만든 뒤
  // skip을 splice 해서 문자열 하나씩 체크하여 알파벳 배열에서 삭제
  // 그 뒤 s도 splice해서 하나씩 하는데 indexOf로 찾아서 +index 해주기
  var answer = "";
  let alphabet = [
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "g",
    "h",
    "i",
    "j",
    "k",
    "l",
    "m",
    "n",
    "o",
    "p",
    "q",
    "r",
    "s",
    "t",
    "u",
    "v",
    "w",
    "x",
    "y",
    "z",
  ];

  skip = skip.split("");
  skip.map((e) => {
    let idx = alphabet.indexOf(e);
    alphabet.splice(idx, 1);
  });
  s = s.split("");
  s.map((e) => {
    let idx = alphabet.indexOf(e);
    // index+5가 z를 넘어갈때와 아닐때 구분
    if (idx + index >= alphabet.length) {
      let alphaLength = alphabet.length;
      let a = (idx + index) % alphaLength;
      answer += alphabet[a];
    } else {
      answer += alphabet[idx + index];
    }
  });
  return answer;
}
