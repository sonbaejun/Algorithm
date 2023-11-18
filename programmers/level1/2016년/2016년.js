function solution(a, b) {
  // 일수로 계산
  // 일수 % 7 로 요일을 유추
  var answer = "";
  let days = 0;
  let month = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
  let yoil = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"];
  for (let i = a - 1; i > 0; i--) {
    days += month[i];
  }
  days += b - 1;
  return yoil[days % 7];
  return answer;
}
