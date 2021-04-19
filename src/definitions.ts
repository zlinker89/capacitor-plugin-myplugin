declare module '@capacitor/core' {
  interface PluginRegistry {
    Alert: AlertPlugin;
  }
}

export interface AlertPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  sumar(options: { value1: number, value2: number  }): Promise<{ suma: number }>;
}
