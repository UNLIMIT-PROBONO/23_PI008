import React from 'react';
import { SimpleSchedule } from '../../molecules/main-home/SimpleSchedule';
import { Text } from '../../atoms/Text';
import { Col, Divider, Row } from 'antd';

export function TodaySchedule(props) {
    const data = props.data; // 배열

    const dummy = [
        {
            "index": 1,
            "content": "have lunch",
            "activated": true,
        },{
            "index": 2,
            "content": "call kim grandma",
            "activated": false,
        },
        {
            "index": 3,
            "content": "hi hello",
            "activated": true,
        },
        {
            "index": 4,
            "content": "sorry",
            "activated": false,
        },
    ]

    return (
        <>
        <Row>
            <Text label={"오늘의 스케줄"} />
        </Row>
        <Row>
            <Col>
            {dummy.map((item) => (
                <Row>
                    <SimpleSchedule 
                        index={item.index} 
                        content={item.content}
                        activated={item.activated}/>
                </Row>
            ))}
            </Col>
        </Row>
        </>
    );
}