const SERVER_HOST = "3.38.92.143";
// const SERVER_HOST = "localhost";
const SERVER_PORT = "8080";

// rest api URI 관리
const MANAGER = "manager";
const SCHEDULE = "schedule";
const MANAGEMENT_TARGET = "user";
const CALENDAR = "calendar";
const DATA = "data";

export const URI = {
  BASE_URL: `http://${SERVER_HOST}:${SERVER_PORT}/api/`,

  MANAGER: `${MANAGER}`,
  LOGIN: `${MANAGER}/login`,
  SIGNUP: `${MANAGER}/signup`,
  CHECK_ID: `${MANAGER}/signup/`,

  MANAGEMENT_TARGET: `${MANAGEMENT_TARGET}`,

  DATA: `${DATA}`,

  SCHEDULE: `${SCHEDULE}`,
  SCHEDULE_HISTORY: `${SCHEDULE}/history`,

  CALENDAR: `${CALENDAR}`,
  THIS_WEEK: `${CALENDAR}/week`,
};

// 페이지 라우팅 URI 관리
export const ROUTE = {};
