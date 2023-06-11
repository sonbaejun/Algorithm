function solution(absolutes, signs) {
    return absolutes.reduce((acc, cur, index) => {
        signs[index] ? acc += cur : acc += (cur * -1);
        return acc;
    }, 0)
}