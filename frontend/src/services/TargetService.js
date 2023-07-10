import { URI } from '../utils/config';
import RestAPI from '../utils/AxiosApi';
import { jsonToTargetInfomation, jsonToUsageForm } from '../mapper/managementTargetMapper';

export async function getTargetInfo(targetId) {
    var result = await RestAPI.get(URI.MANAGEMENT_TARGET + `/${targetId}`)
        .then((res) => {
            if (res.status === 200) {
                return jsonToTargetInfomation(res.data);
            }
        }).catch((error) => console.log(error));

    return result
}

export async function getTargetUsage(targetId) {
    var result = await RestAPI.get(URI.MANAGEMENT_TARGET + `/${targetId}/usage`)
        .then((res) => {
            if (res.status === 200) {
                return jsonToUsageForm(res.data);
            }
        }).catch((error) => {
            console.log(error);
        });

    return result;
}

export function getOriginalAge(birth) {
    const today = new Date();
    var age = today.getFullYear() - birth.getFullYear();
    var mon = (today.getMonth() + 1) - birth.getMonth();
    if (mon < 0 || (mon === 0 && today.getDate() < birth.getDate())) {
        return age - 1;
    }
    return age;
}

export function returnComparisonRatio(value, avg) {
    // (사용량-평균)/평균, 양수%면 증가, 음수%면 감소
    return Math.round((value - avg) * 100 / avg, 2);
}