import React from 'react';
import { Text } from '../../atoms/Text';
import { Row } from 'antd';
import { HistoryTable } from '../../molecules/management-target/HistoryTable';

export function ManagementHistory(props) {
    return (
        <>
            <Row>
                <Text label="과거 관리 내역" />
            </Row>
            <Row>
                <HistoryTable history={props.data} />
            </Row>
        </>
    );
}