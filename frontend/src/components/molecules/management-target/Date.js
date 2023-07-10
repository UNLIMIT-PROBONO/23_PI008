import { Col, Row } from 'antd';
import React from 'react';
import { dateFormatting } from '../../../utils/mapper';
import { Text } from '../../atoms/Text';

export function LabeledDate(props) {
    var formatted = dateFormatting(props.date);
    return (
        <Row>
            <Col>
                <Text label={props.label} />
            </Col>
            <Col>
                <Text label={formatted} />
            </Col>
        </Row>
    )
}
