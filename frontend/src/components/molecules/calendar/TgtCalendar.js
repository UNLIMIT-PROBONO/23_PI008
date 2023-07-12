import React from 'react';
import FullCalendar from '@fullcalendar/react';
import dayGridPlugin from '@fullcalendar/daygrid' // a plugin!
import interactionPlugin from "@fullcalendar/interaction" // needed for dayClick

export function TgtCalendar(props) {
    
    const renderEventContent = props.renderEventContent; // 월이 바뀌었을 때
    const schedules = [
        {
            title: "내용", 
            start: new Date(2023, 6,3),
            end: new Date(2023, 6,6),
            
        },{
            title: "내용11", 
            start: new Date(2023, 6,3),
            end: new Date(2023, 6,6),
        },
    ]
    // TODO dateClick -> 일정 추가 폼 나오게
    
    return(
        <>
        <FullCalendar
            plugins={[ dayGridPlugin, interactionPlugin ]}
            initialView='dayGridMonth'
            events={schedules}
            eventContent={renderEventContent}
        />
        </>
    );
}
// https://fullcalendar.io/docs/react