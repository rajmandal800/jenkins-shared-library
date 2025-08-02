/**
 * This file provides type definitions for Jenkins Pipeline
 * to enable better IntelliSense in VS Code
 */

// Jenkins Pipeline Script object
declare var script: any;

// Jenkins Pipeline steps
declare function echo(message: string): void;
declare function sh(script: string): any;
declare function bat(script: string): any;
declare function powershell(script: string): any;
declare function withCredentials(bindings: any[], body: () => void): void;
declare function usernamePassword(options: {
  credentialsId: string;
  passwordVariable: string;
  usernameVariable: string;
}): any;
declare function node(label?: string, body?: () => void): void;
declare function stage(name: string, body: () => void): void;
declare function parallel(branches: { [key: string]: () => void }): void;
declare function build(job: string, parameters?: any[]): any;
declare function publishHTML(options: any): void;
declare function archiveArtifacts(artifacts: string): void;
declare function junit(testResults: string): void;
declare function checkout(scm: any): void;
declare function git(options: any): void;
declare function dir(path: string, body: () => void): void;
declare function timeout(time: number, unit?: string, body?: () => void): void;
declare function retry(count: number, body: () => void): void;
declare function sleep(time: number): void;
declare var currentBuild: any;
declare var env: { [key: string]: string };
declare var params: { [key: string]: any };
declare var BRANCH_NAME: string;
declare var BUILD_NUMBER: string;
declare var BUILD_URL: string;
declare var JOB_NAME: string;
declare var WORKSPACE: string;
