import { Checkbox, Col, Row } from 'antd';
import React from 'react';
import { Text } from '../../atoms/Text';

export function SimpleSchedule(props) {
    const index = props.index;
    const scheduleId = props.scheduleId;
    const content = props.content;
    const activated = props.activated;

    return (
        <Row>
            <Col>
                <Text label={index}/>
            </Col>
            <Col>
                <Checkbox defaultChecked={activated} disabled/>
            </Col>
            <Col>
                <Text label={content}/>
            </Col>
        </Row>
    );
}