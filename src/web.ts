import { WebPlugin } from '@capacitor/core';
import { AlertPlugin } from './definitions';

export class AlertWeb extends WebPlugin implements AlertPlugin {
  constructor() {
    super({
      name: 'Alert',
      platforms: ['web'],
    });
  }

  async sumar(options: { value1: number; value2: number; }): Promise<{ suma: number; }> {
    console.log('ECHO', options);
    return {
      suma: 0
    };
  }

  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}

const Alert = new AlertWeb();

export { Alert };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(Alert);
