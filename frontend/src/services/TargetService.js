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