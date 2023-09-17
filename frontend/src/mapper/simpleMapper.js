export const dateFormatting = (source) => {
  const year = source.getFullYear();
  const month = source.getMonth() + 1;
  const day = source.getDate();
  return year + "년 " + month + "월 " + day + "일";
};

export const jsonToDatetime = (str) => {
  return new Date(str);
};

export const getOriginalAge = (jsonBirth) => {
  const today = new Date();
  const birth = new Date(jsonBirth);
  var age = today.getFullYear() - birth.getFullYear();
  var mon = today.getMonth() + 1 - birth.getMonth();
  if (mon < 0 || (mon === 0 && today.getDate() < birth.getDate())) {
    return age - 1;
  }
  return age;
};

export const returnComparisonRatio = (value, avg) => {
  // (사용량-평균)/평균, 양수%면 증가, 음수%면 감소
  return Math.round(((value - avg) * 100) / avg, 2);
};