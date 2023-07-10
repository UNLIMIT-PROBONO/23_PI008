import React from 'react';
import { SimpleSchedule } from '../../molecules/main-home/SimpleSchedule';
import { Text } from '../../atoms/Text';
import { Col, Divider, Row } from 'antd';

export function AfterTodaysSchedule(props) {
    const data = props.data; // 배열

    const dummy = [
        {
            "index": 1,
            "scheduleId": 123,
            "content": "have lunch",
            "activated": true,
        }, {
            "index": 2,
            "scheduleId": 123,
            "content": "call kim grandma",
            "activated": false,
        },
        {
            "index": 3,
            "scheduleId": 123,
            "content": "hi hello",
            "activated": true,
        },
        {
            "index": 4,
            "scheduleId": 123,
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
                                scheduleId={item.scheduleId}
                                content={item.content}
                                activated={item.activated} />
                        </Row>
                    ))}
                </Col>
            </Row>
        </>
    );
}