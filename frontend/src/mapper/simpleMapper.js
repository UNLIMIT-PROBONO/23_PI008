export function dateFormatting(source) {
    const year = source.getFullYear();
    const month = (source.getMonth() + 1);
    const day = (source.getDate());
    return year+"년 "+month+"월 "+day+"일";
}
