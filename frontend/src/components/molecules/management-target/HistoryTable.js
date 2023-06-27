import { Table } from 'antd';
import React from 'react';
import { dateFormatting } from '../../../utils/mapper';

export function HistoryTable(props) {
    const dataSource=props.history;

    // 일시, 제목, 상세 내용 , 수행여부(Activated)
    const colums = [
        {
            title: "일시",
            dataIndex: "start_date",
            key: "start_date",
            render: (start_date)=>{
                return dateFormatting(start_date)
            }
        },
        {
            title: "내용",
            dataIndex: "title",
            key: "title",
        },
        {
            title: "상세",
            dataIndex: "content",
            key: "content",
        },
        {
            title: "수행 여부",
            dataIndex: "activated",
            key: "activated",
            render: (activated) => {
                return (activated==="ACTIVATED")? "Y":"N"
            }
        }
    ]

    return(
        <>
        <Table dataSource={dataSource} columns={colums}/>
        </>
    )
}