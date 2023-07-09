import { Col, Row } from 'antd';
import React from 'react';
import { UsageBarChart } from '../../molecules/management-target/UsageBarChart';
import { Text } from '../../atoms/Text';

export function UsageComparison(props) {
    const data = props.data;

    return(
        <>
        <Text label="전주 대비 사용량 증감"/>
        <Row>
            <Col>
                <UsageBarChart data={data.call} />
            </Col>
            <Col>
                <UsageBarChart data={data.water} />
            </Col>
            <Col>
                <UsageBarChart data={data.elec} showLegends={true}/>
            </Col>
        </Row>
        </>
    )
}