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
export const TgtCalendar = (props) => {
  var [data, setData] = useState({});
  var [isModalOpen, openModal, closeModal] = useModal(false);

  const renderEventContent = props.renderEventContent; // 월이 바뀌었을 때
  const schedules = props.schedules;

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
