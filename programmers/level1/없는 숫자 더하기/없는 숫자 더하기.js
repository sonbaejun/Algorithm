function solution(numbers) {
    return numbers.reduce((acc, cur) => {
        acc -= cur;
        return acc;
    }, 45)
}