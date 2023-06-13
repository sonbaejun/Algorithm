function solution(a, b) {
    /* a⊕b와 b⊕a 계산 */
    let abStr = a.toString() + b.toString();
    let baStr = b.toString() + a.toString();
    /* 더 큰걸 정수형으로 변환하여 리턴 */
    return abStr >= baStr ? parseInt(abStr) : parseInt(baStr)
}