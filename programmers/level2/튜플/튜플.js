function solution(s) {
    var answer = [];
    let arr1 = [];
    let arr2 = [];
    let index = 1;
    let slength = 0;
    /* 순수하게 숫자들만 남도록 s 변형 */
    s = s.split('{').join('').split('}').join('').split(',');
    let a1 = s.length * 2;
    /* 튜플의 길이 찾기 */
    while (index < 1000000) {
        if (index * index + index == a1) {
            slength = index;
            index = 1000000;
        } else {
            index++;
        }
    }
    /* 배열 두개를 사용하여 각 원소가 몇번나왔는지 기록 */
    s.map(e => {
        let index = arr1.indexOf(e);
        if (index == -1) {
            arr1.push(e);
            arr2.push(1);
        } else
            arr2[index]++;
    })
    /* slength(길이)만큼 가장 많이 나온놈이 가장 앞 원소이므로 앞에부터 하나씩 삽입 */
    arr1.map(e => {
        let index = arr2.indexOf(slength);
        answer.push(parseInt(arr1[index]));
        slength--;
    })
    return answer;
}