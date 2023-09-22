const SERVER_HOST = process.env.REACT_APP_API_SERVER_HOST;
const SERVER_PORT = process.env.REACT_APP_API_SERVER_PORT;

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
  LOGOUT: `${MANAGER}/logout`,
  SIGNUP: `${MANAGER}/signup`,
  CHECK_ID: `${MANAGER}/signup/`,

  MANAGEMENT_TARGET: `${MANAGEMENT_TARGET}`,
  USER_DANGER: `${MANAGEMENT_TARGET}/danger`,

  DATA: `${DATA}`,

  SCHEDULE: `${SCHEDULE}`,
  SCHEDULE_HISTORY: `${SCHEDULE}/history`,

  CALENDAR: `${CALENDAR}`,
  THIS_WEEK: `${CALENDAR}/week`,
};
