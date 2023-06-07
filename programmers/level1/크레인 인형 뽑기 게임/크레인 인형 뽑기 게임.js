function solution(board, moves) {
    var answer = 0;
    let bucket = []; /* 바구니 */
    for (let i = 0; i < moves.length; i++) {
        let popNumber = 0;
        let index = 0;
        let cnt = 0;
        /* 바구니에 담는 반복문, 0이면 다시 뽑기 */
        while (popNumber == 0 && cnt < board.length) {
            cnt++;
            popNumber = board[index][moves[i] - 1];
            if (popNumber == 0) {
                index++;
            } else {
                bucket.push(popNumber);
                board[index][moves[i] - 1] = 0;
            }
        }
    }
    let range = bucket.length;
    /* 바구니에 다 담은 뒤, 겹치는 인형들 터트리기 */
    for (let i = 0; i < range; i++) {
        if (bucket[i] == bucket[i + 1]) {
            answer++;
            bucket.splice(i, 2);
            if (i == 0) {
                i = 0;
                range--;
            } else {
                i -= 2;
                range -= 2;
            }
        }
    }
    return answer * 2;
}