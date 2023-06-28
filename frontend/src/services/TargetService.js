import React from 'react';

export function getOriginalAge(birth) {
    const today = new Date();
    var age = today.getFullYear() - birth.getFullYear();
    var mon = (today.getMonth()+1) - birth.getMonth();
    if (mon <0 || (mon===0 && today.getDate() < birth.getDate())) {
        return age-1;
    }
    return age;
}

export function returnComparisonRatio(value, avg) {
    // (사용량-평균)/평균, 양수%면 증가, 음수%면 감소
    return Math.round((value-avg)*100/avg,2);
}