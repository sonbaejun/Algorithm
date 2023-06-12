function solution(n) {
    var answer = 1000000;
    for (let i = 1; i < answer; i++) {
        if (n % i == 1)
            answer = i;
    }
    return answer;
}