import React, { useState } from "react";
import FullCalendar from "@fullcalendar/react";
import dayGridPlugin from "@fullcalendar/daygrid"; // a plugin!
import interactionPlugin from "@fullcalendar/interaction"; // needed for dayClick
import { ScheduleModal } from "../../organisms/calendar/ScheduleModal";
import { useModal } from "../../../hook/useModal";
import styled from "styled-components";

const CalendarWrap = styled.div`
  width: 100vw;
  height: 100vw;
`
export function TgtCalendar(props) {
  var [data, setData] = useState({});
  var [isModalOpen, openModal, closeModal] = useModal(false);

  const renderEventContent = props.renderEventContent; // 월이 바뀌었을 때
  const schedules = [
    {
      title: "내용",
      start: new Date(2023, 6, 3),
      end: new Date(2023, 6, 6),
    },
    {
      title: "내용11",
      start: new Date(2023, 6, 3),
      end: new Date(2023, 6, 6),
    },
  ];
  // TODO dateClick -> 일정 추가 폼 나오게

  return (
    <CalendarWrap>
      <FullCalendar
        plugins={[dayGridPlugin, interactionPlugin]}
        initialView="dayGridMonth"
        events={schedules}
        dateClick={openModal}
      />

      <ScheduleModal isOpen={isModalOpen} closeModal={closeModal} />
    </CalendarWrap>
  );
}
// https://fullcalendar.io/docs/react
