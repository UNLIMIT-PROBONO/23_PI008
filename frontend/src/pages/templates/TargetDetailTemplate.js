import React from 'react';
import { PrivacyInformation } from '../../components/organisms/management-target/PrivacyInformation';
import { ManagementHistory } from '../../components/organisms/management-target/ManagementHistory';
import { UsageComparison } from '../../components/organisms/management-target/UsageComparison';

export function TargetDetailTemplate(props) {
    const managementHistory = props.managementHistory;
    // const targetInfomation = props.targetInfomation;
    // const targetUsage = props.targetUsage;

    const targetInfomation= {
        "name":"이름 ",
        "birth" : new Date(1928,3,5),
        "address":"경기도",
        "phone_number":"010111112222",
    }
    const targetUsage = {
        "call":[
            {
                "id": "call",
                "value": 1233,
                "todayUsage" : 344,
                "weekAvg" : 234,
            },
        ],
        "water":[
            {
                "id": "water",
                "todayUsage" : 233,
                "weekAvg" : 234,
            },
        ],
        "elec":[
            {
                "id": "elec",
                "todayUsage" : 321,
                "weekAvg" : 234,
            }
        ]
    }

    return(
        <>
            <PrivacyInformation data={targetInfomation}/>
            <UsageComparison data={targetUsage}/>
            <ManagementHistory data={managementHistory} />
        </>
    )
}