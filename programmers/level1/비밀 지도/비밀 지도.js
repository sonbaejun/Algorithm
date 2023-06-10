function solution(n, arr1, arr2) {
    var answer = [];
    let a1 = [];
    let a2 = [];
    for (let i = 0; i < n; i++) {
        let word = '';
        a1 = arr1[i].toString(2).split('');
        a2 = arr2[i].toString(2).split('');
        if (a1.length < n) {
            let index = n - a1.length;
            for (let k = 0; k < index; k++)
                a1.splice(0, 0, '0');
        }
        if (a2.length < n) {
            let index = n - a2.length;
            for (let k = 0; k < index; k++)
                a2.splice(0, 0, '0');
        }
        for (let j = 0; j < n; j++) {
            a1[j] == 1 || a2[j] == 1 ? word += '#' : word += ' ';
        }
        answer.push(word);
    }
    return answer;
}