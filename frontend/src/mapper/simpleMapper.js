export const dateFormatting = (source) => {
  const year = source.getFullYear();
  const month = source.getMonth() + 1;
  const day = source.getDate();
  return year + "년 " + month + "월 " + day + "일";
};
export const jsonToDatetime = (str) => {
  return new Date(str);
};
