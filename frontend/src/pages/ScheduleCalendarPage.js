import React, { useState } from "react";
import { ScheduleCalendarTemplate } from "./templates/ScheduleCalendarTemplate";
import { BasicFrame } from "../components/organisms/layout/BasicFrame";

export function ScheduleCalendarPage(props) {
  var [loading, setLoading] = useState(false);
  var [data, setData] = useState({});

  return (
    <>
      {loading ? (
        <div>로딩중</div>
      ) : (
        <BasicFrame content={() => <ScheduleCalendarTemplate data={data} />} />
      )}
    </>
  );
}
